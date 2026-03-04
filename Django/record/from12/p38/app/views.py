from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User
from django.shortcuts import redirect, render

from .models import LoginLog


def register_view(request):
    error = ''

    if request.method == 'POST':
        username = request.POST.get('username', '').strip()
        password = request.POST.get('password', '').strip()

        if not username or not password:
            error = 'Username and password are required.'
        elif User.objects.filter(username=username).exists():
            error = 'Username already exists.'
        else:
            User.objects.create_user(username=username, password=password)
            return redirect('login')

    return render(request, 'app/register.html', {'error': error})


def login_view(request):
    error = ''

    if request.method == 'POST':
        username = request.POST.get('username', '').strip()
        password = request.POST.get('password', '').strip()
        user = authenticate(request, username=username, password=password)

        if user is not None:
            login(request, user)
            LoginLog.objects.create(username=user.username)
            return redirect('dashboard')
        error = 'Invalid username or password.'

    return render(request, 'app/login.html', {'error': error})


def logout_view(request):
    logout(request)
    return redirect('login')


@login_required
def dashboard_view(request):
    return render(request, 'app/dashboard.html')
