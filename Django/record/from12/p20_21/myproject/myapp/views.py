from django.shortcuts import render, get_object_or_404, redirect
from django.http import HttpResponse
from .models import Student
from django.views.generic import ListView

# READ (List all students)
def student_list(request):
    students = Student.objects.all()
    return render(request, "student_list.html", {"students": students}) 

def student_detail(request, id):
    student = get_object_or_404(Student, id=id)
    return render(request, "detail.html", {"student": student})

""" # Class-Based View
class StudentListView(ListView):
    model = Student
    template_name = "student_list.html"
    context_object_name = "students" """

# CREATE (Add new student)
def student_create(request):
    if request.method == "POST":
        name = request.POST.get("name")
        age = request.POST.get("age")
        email = request.POST.get("email")
        Student.objects.create(name=name, age=age, email=email)
        return redirect("student_list")
    return render(request, "student_create.html")

# UPDATE (Edit existing student)
def student_update(request, id):
    student = Student.objects.get(id=id)
    if request.method == "POST":
        student.name = request.POST.get("name")
        student.age = request.POST.get("age")
        student.email = request.POST.get("email")
        student.save()
        return redirect("student_list")
    return render(request, "student_update.html", {"student": student})

# DELETE (Delete a student)
def student_delete(request, id):
    student = Student.objects.get(id=id)
    if request.method == "POST":
        student.delete()
        return redirect("student_list")
    return render(request, "student_delete.html", {"student": student})
