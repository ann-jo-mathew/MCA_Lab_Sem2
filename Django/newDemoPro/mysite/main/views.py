from django.shortcuts import render,redirect

# Create your views here.
from .models import Student,Course

def home(request):
    students = Student.objects.all()   # get all student records
    courses=Course.objects.all()
    return render(request, 'index.html',{'students': students,'courses':courses})

def deletestudent(request):
    studentId=request.GET.get("studentId") #there are diffrent method for doing that like httpreq
    if studentId:
        student = Student.objects.filter(id=studentId) #multiple method
        student.delete()
    return redirect('home')
