from django.contrib.auth import authenticate, login, logout
from django.shortcuts import redirect, render
from django.utils import timezone

from .models import Note


def home(request):
    count = request.session.get('visit_count', 0) + 1
    request.session['visit_count'] = count

    last_visited = request.session.get('last_visited')
    now = timezone.now().strftime('%Y-%m-%d %H:%M:%S')
    request.session['last_visited'] = now

    username = request.session.get('username', 'Guest')
    theme = request.session.get('theme', 'light')
    notes = Note.objects.all()

    context = {
        'visit_count': count,
        'last_visited': last_visited,
        'username': username,
        'theme': theme,
        'notes': notes,
    }
    return render(request, 'app/home.html', context)


def set_name(request):
    if request.method == 'POST':
        name = request.POST.get('username', '').strip()
        if name:
            request.session['username'] = name
    return redirect('home')


def set_theme(request):
    if request.method == 'POST':
        theme = request.POST.get('theme', 'light')
        if theme in ['light', 'dark']:
            request.session['theme'] = theme
    return redirect('home')


def clear_session(request):
    request.session.flush()
    return redirect('home')


def user_login(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(request, username=username, password=password)

        if user is not None:
            login(request, user)
            return redirect('home')

        return render(request, 'app/login.html', {'error': 'Invalid username or password'})

    return render(request, 'app/login.html')


def user_logout(request):
    logout(request)
    return redirect('home')
