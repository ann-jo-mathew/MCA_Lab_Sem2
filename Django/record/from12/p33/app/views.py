from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required, user_passes_test
from .models import Feedback

def feedback_form(request):
    errors = {}
    success = False
    data = {}

    if request.method == "POST":
        data['name'] = request.POST.get('name', '').strip()
        data['email'] = request.POST.get('email', '').strip()
        data['rating'] = request.POST.get('rating', '')
        data['message'] = request.POST.get('message', '').strip()

        # Validation
        if not data['name']:
            errors['name'] = "Name is required."
        
        if not data['email']:
            errors['email'] = "Email is required."

        try:
            rating = int(data['rating'])
            if rating < 1 or rating > 5:
                errors['rating'] = "Rating must be between 1 and 5."
        except (ValueError, TypeError):
            errors['rating'] = "A valid rating is required."

        if len(data['message']) < 10:
            errors['message'] = "Message must be at least 10 characters long."

        if not errors:
            Feedback.objects.create(
                name=data['name'],
                email=data['email'],
                rating=int(data['rating']),
                message=data['message']
            )
            success = True
            data = {} # Clear form on success
    
    return render(request, 'app/form.html', {'errors': errors, 'success': success, 'data': data})

@login_required
@user_passes_test(lambda u: u.is_staff)
def feedback_list(request):
    feedbacks = Feedback.objects.all().order_by('-created_at')
    return render(request, 'app/list.html', {'feedbacks': feedbacks})
