from django.core.management.base import BaseCommand
from app.models import Student


class Command(BaseCommand):
    help = 'Seed 25 sample students'

    def handle(self, *args, **kwargs):
        for i in range(1, 26):
            Student.objects.get_or_create(
                email=f'student{i}@example.com',
                defaults={
                    'name': f'Student {i}',
                    'age': 18 + (i % 5),
                }
            )
        self.stdout.write(self.style.SUCCESS('25 students seeded successfully.'))
