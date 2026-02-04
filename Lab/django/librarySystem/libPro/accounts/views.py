from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User

def user_login(request):
    if request.method == "POST":
        username = request.POST.get('username')
        password = request.POST.get('password')

        user = authenticate(request, username=username, password=password)

        if user:
            login(request, user)
            return redirect('dashboard')
        else:
            return render(request, 'accounts/login.html', {
                'error': 'Invalid username or password'
            })

    return render(request, 'accounts/login.html')


def user_logout(request):
    logout(request)
    return redirect('login')


def user_register(request):
    if request.method == "POST":
        username = request.POST.get('username')
        email = request.POST.get('email')
        password1 = request.POST.get('password1')
        password2 = request.POST.get('password2')

        # validations
        if password1 != password2:
            return render(request, 'accounts/register.html', {
                'error': 'Passwords do not match'
            })

        if User.objects.filter(username=username).exists():
            return render(request, 'accounts/register.html', {
                'error': 'Username already exists'
            })

        # create user
        User.objects.create_user(
            username=username,
            email=email,
            password=password1
        )

        return redirect('login')

    return render(request, 'accounts/register.html')
