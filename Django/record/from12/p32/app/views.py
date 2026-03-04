from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth.decorators import login_required
from .models import Student

@login_required
def student_list(request):
    students = Student.objects.all()
    return render(request, 'app/list.html', {'students': students})

@login_required
def student_create(request):
    if request.method == "POST":
        name = request.POST.get('name')
        age = request.POST.get('age')
        email = request.POST.get('email')
        department = request.POST.get('department')
        Student.objects.create(name=name, age=age, email=email, department=department)
        return redirect('student_list')
    return render(request, 'app/form.html')

@login_required
def student_update(request, id):
    student = get_object_or_404(Student, id=id)
    if request.method == "POST":
        student.name = request.POST.get('name')
        student.age = request.POST.get('age')
        student.email = request.POST.get('email')
        student.department = request.POST.get('department')
        student.save()
        return redirect('student_list')
    return render(request, 'app/form.html', {'student': student})

@login_required
def student_delete(request, id):
    student = get_object_or_404(Student, id=id)
    if request.method == "POST":
        student.delete()
        return redirect('student_list')
    return render(request, 'app/confirm_delete.html', {'student': student})
