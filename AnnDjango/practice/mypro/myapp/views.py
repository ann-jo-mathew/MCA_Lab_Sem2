from django.shortcuts import render,redirect,get_object_or_404
from django.contrib.auth import authenticate,login,logout
from django.contrib.auth.decorators import login_required
from .forms import login_form,StudentForm
from .models import Student

# Create your views here.
""" def login_view(request):    #request contains GET,POST,session,user...
    if request.method=="POST":  #checks if user submitted the loginform
        un=request.POST["username"]#gets username enterd in the form
        ps=request.POST["password"]#requets.POST is directory that stores data from form
        user=authenticate(request,username=un,password=ps)#comapres it with built in User table, verifies password hash
        if user:#if autehntication success then user var has user object otherwise none(user = valid user OR None)
            login(request,user)#logs the user, create session, stores user ID in session
                                #request.user contains logged-in user
            return redirect(dashboard)#after login goes to dashboard page
                                #redirect means open another url/view
    return render(request,"login.html")
 """
def login_view(request):
    if request.method=="POST":
        form=login_form(request.POST) 
        if form.is_valid():
              un=form.cleaned_data["username"]#cleaned_data is a dictionary that stores form data after validation
              ps=form.cleaned_data["password"]
              user=authenticate(request,username=un,password=ps)
              if user:
                login(request,user)
                return redirect('dashboard')
    else:
        form=login_form()
    return render(request,"login.html",{"form":form})

@login_required
def dashboard(request):
    return render(request, "dashboard.html")

def logout_view(request):
    logout(request)
    return redirect(login_view)

#@login_required
def list_view(request):
    st=Student.objects.all()
    return render(request, 'list.html',{'students':st})

def edit_view(request,id):
    st=get_object_or_404(Student,id=id)
    if request.method=="POST":
        form=StudentForm(request.POST,instance=st)
        if form.is_valid():
            form.save()
            return redirect('list')
    else:
        form=StudentForm(instance=st)
    return render(request, 'edit.html',{'form':form})

def delete_view(request,id):
    st=get_object_or_404(Student,id=id)
    if request.method=='POST':
        st.delete()
        return redirect('list')
    return render(request, 'delete_con.html',{'student':st})

def create_view(request):
    if request.method=='POST':
        form=StudentForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('list')
    else:
        form=StudentForm()
    return render(request,"create.html",{'form':form})