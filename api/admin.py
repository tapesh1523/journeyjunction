from django.contrib import admin
from .models import Country, State, City, Place, FoodPlace, Thing, AttractionType, SuitableFor

# Register your models here.
admin.site.register(Country)
admin.site.register(State)
admin.site.register(City)
admin.site.register(Place)
admin.site.register(FoodPlace)
admin.site.register(Thing)
admin.site.register(AttractionType)
admin.site.register(SuitableFor)
