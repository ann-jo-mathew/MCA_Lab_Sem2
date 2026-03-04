from django.core.validators import validate_email
from django.core.exceptions import ValidationError
from django.shortcuts import render

from .models import Student


def student_add(request):
    errors = {}
    data = {}
    success = ''

    if request.method == 'POST':
        name = request.POST.get('name', '').strip()
        age = request.POST.get('age', '').strip()
        email = request.POST.get('email', '').strip()

        data = {'name': name, 'age': age, 'email': email}

        if not name:
            errors['name'] = 'Name is required.'
        elif len(name) < 3:
            errors['name'] = 'Name must be at least 3 characters.'

        if not age:
            errors['age'] = 'Age is required.'
        else:
            try:
                age_int = int(age)
                if age_int < 1 or age_int > 120:
                    errors['age'] = 'Age must be between 1 and 120.'
            except ValueError:
                errors['age'] = 'Age must be an integer.'

        if not email:
            errors['email'] = 'Email is required.'
        else:
            try:
                validate_email(email)
            except ValidationError:
                errors['email'] = 'Enter a valid email address.'

            if Student.objects.filter(email=email).exists():
                errors['email'] = 'Email already exists.'

        if not errors:
            try:
                Student.objects.create(name=name, age=age_int, email=email)
                success = 'Student saved successfully.'
                data = {}
            except Exception:
                errors['general'] = 'Something went wrong while saving data.'

    return render(request, 'app/student_form.html', {'errors': errors, 'data': data, 'success': success})
