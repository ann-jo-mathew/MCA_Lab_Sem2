from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required

from .models import Profile


# Registration with role

def register(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        role = request.POST.get('role')

        if User.objects.filter(username=username).exists():
            return render(request, 'register.html', {'error': 'Username already exists'})

        user = User.objects.create_user(username=username, password=password)
        Profile.objects.create(user=user, role=role)
        return redirect('login')

    return render(request, 'register.html')


# Login

def user_login(request):
    if request.user.is_authenticated:
        profile, _ = Profile.objects.get_or_create(user=request.user, defaults={'role': 'STUDENT'})
        if profile.role == 'ADMIN':
            return redirect('admin_dashboard')
        if profile.role == 'STAFF':
            return redirect('staff_dashboard')
        return redirect('student_dashboard')

    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')

        user = authenticate(request, username=username, password=password)

        if user:
            login(request, user)
            profile, _ = Profile.objects.get_or_create(user=user, defaults={'role': 'STUDENT'})

            if profile.role == 'ADMIN':
                return redirect('admin_dashboard')
            if profile.role == 'STAFF':
                return redirect('staff_dashboard')
            return redirect('student_dashboard')

        return render(request, 'login.html', {'error': 'Invalid username or password'})

    return render(request, 'login.html')



def user_logout(request):
    logout(request)
    return redirect('login')


@login_required
def dashboard(request):
    profile, _ = Profile.objects.get_or_create(user=request.user, defaults={'role': 'STUDENT'})
    return render(request, 'dashboard.html', {'role': profile.role})


@login_required
def admin_dashboard(request):
    profile, _ = Profile.objects.get_or_create(user=request.user, defaults={'role': 'STUDENT'})
    if profile.role != 'ADMIN':
        return redirect('dashboard')
    return render(request, 'dashboard.html', {'role': profile.role})


@login_required
def staff_dashboard(request):
    profile, _ = Profile.objects.get_or_create(user=request.user, defaults={'role': 'STUDENT'})
    if profile.role != 'STAFF':
        return redirect('dashboard')
    return render(request, 'dashboard.html', {'role': profile.role})


@login_required
def student_dashboard(request):
    profile, _ = Profile.objects.get_or_create(user=request.user, defaults={'role': 'STUDENT'})
    if profile.role != 'STUDENT':
        return redirect('dashboard')
    return render(request, 'dashboard.html', {'role': profile.role})
