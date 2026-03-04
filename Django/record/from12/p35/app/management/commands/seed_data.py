from django.core.management.base import BaseCommand
from app.models import Note


class Command(BaseCommand):
    help = 'Insert sample note data'

    def handle(self, *args, **kwargs):
        samples = [
            ('Welcome', 'This is a sample note for session project.'),
            ('Tip', 'Use set-name to store a name in session.'),
            ('Theme', 'Use set-theme to store preferred theme in session.'),
        ]

        for title, message in samples:
            Note.objects.get_or_create(title=title, defaults={'message': message})

        self.stdout.write(self.style.SUCCESS('Sample data inserted.'))
