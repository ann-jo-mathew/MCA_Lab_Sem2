from django.core.paginator import Paginator
from django.db.models import Q
from django.shortcuts import render

from .models import Student


def student_list(request):
    q = request.GET.get('q', '').strip()

    students = Student.objects.all().order_by('id')
    if q:
        students = students.filter(Q(name__icontains=q) | Q(email__icontains=q))

    paginator = Paginator(students, 5)
    page_number = request.GET.get('page')
    page_obj = paginator.get_page(page_number)

    return render(request, 'app/student_list.html', {'page_obj': page_obj, 'q': q})
