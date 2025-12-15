from django.shortcuts import render,redirect
from django.contrib.auth import authenticate,login,logout
from django.contrib.auth.forms import AuthenticationForm
from .forms import RegisterForm


def home_view(request):
    return render(request,'user/home.html')

def register_view(request):
    if request.method=='POST':
        form=RegisterForm(request.POST)
        if form.is_valid():
            user=form.save(commit=False)
            user.set_password(form.cleaned_data['password'])
            user.save()
            return redirect('login')
    else:
        form=RegisterForm()
    return render(request,'user/register.html',{'form':form})

def login_view(request):
    if request.method=='POST':
        form=AuthenticationForm(data=request.POST)
        if form.is_valid():
            username=form.cleaned_data.get('username')
            password=form.cleaned_data.get('password')
            user=authenticate(username=username,password=password)
            if user:
                login(request,user)
                return redirect('home')
    else:
        form=AuthenticationForm()
    return render(request,'user/login.html',{'form':form})

def logout_view(request):
    logout(request)
    return redirect('login')
