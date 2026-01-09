from django.shortcuts import render,redirect #loads html page, redirects to another url
from django.contrib.auth import authenticate, login #checks username and password, crete session for user
from django.contrib import messages #used to send messages to templates

# Create your views here.
def login_view(request): #req contains form data, session info, user info
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        
        user = authenticate(request,username=username, password=password) #checks username and password matches
                                                                            #returns user pbject(valid), or none(invalid)
        
        if user is not None:
            login(request,user)
            messages.success(request,"Login successful")
            return redirect('dashboard')
        else:
            messages.error(request, "invalid username or password")
    
    return render(request,'LoginApp/login.html')

def dashboard_view(request):
    return render(request,'LoginApp/dashboard.html')