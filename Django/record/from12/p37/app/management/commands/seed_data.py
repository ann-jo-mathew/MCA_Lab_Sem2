from django.core.management.base import BaseCommand
from app.models import Student


class Command(BaseCommand):
    help = 'Seed 3 students'

    def handle(self, *args, **kwargs):
        students = [
            ('Alice', 20, 'alice@example.com'),
            ('Bob', 22, 'bob@example.com'),
            ('Carol', 19, 'carol@example.com'),
        ]

        for name, age, email in students:
            Student.objects.get_or_create(email=email, defaults={'name': name, 'age': age})

        self.stdout.write(self.style.SUCCESS('3 students seeded successfully.'))
