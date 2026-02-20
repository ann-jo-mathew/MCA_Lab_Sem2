from django.shortcuts import render,redirect,get_object_or_404;
from .models import Student
#from .forms import StudentForm

# Create your views here.
# READ
def home(request):
    students = Student.objects.all()
    return render(request, 'index.html', {'students': students})

# CREATE
def addstudent(request):
    if request.method == "POST":
        name = request.POST.get('name')
        age = request.POST.get('age')
        email = request.POST.get('email')

        Student.objects.create(name=name, age=age, email=email)
        return redirect('home')

    return render(request, 'student_add.html')

# UPDATE
def editstudent(request, pk):
    student = get_object_or_404(Student, id=pk)

    if request.method == "POST":
        student.name = request.POST.get('name')
        student.age = request.POST.get('age')
        student.email = request.POST.get('email')
        student.save()
        return redirect('home')

    return render(request, 'student_edit.html', {'student': student})

# DELETE (POST confirm)
def deletestudent(request, pk):
    student = get_object_or_404(Student, id=pk)
    if request.method == "POST":
        student.delete()
        return redirect('home')
    return render(request, 'student_delete.html', {'student': student})

