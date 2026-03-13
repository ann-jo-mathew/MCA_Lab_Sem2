from django.shortcuts import render,redirect
from django.contrib.auth import authenticate,login,logout
from .forms import login_form
from django.contrib.auth.decorators import login_required

# Create your views here.
def login_view(request):
    error=""
    if request.method=="POST":  
        form=login_form(request.POST)
        if form.is_valid():
            un=form.cleaned_data["username"]
            ps=form.cleaned_data["password"]
            user=authenticate(request,username=un,password=ps)
            if user:
                login(request,user)
                return redirect('dashboard')
            else:
                error="Invalid Login"
    else:
        form=login_form()
    return render(request,"login.html",{"form":form,"error":error})

@login_required(login_url='login')
def dashboard_view(request):
    return render(request,"dashboard.html")

def logout_view(request):
    logout(request)
    return redirect('login')