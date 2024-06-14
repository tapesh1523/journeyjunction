from rest_framework import serializers
from .models import Country, State, City, Place, FoodPlace, Thing
from rest_framework.validators import UniqueValidator

class CountrySerializer(serializers.ModelSerializer):
  class Meta:
    model = Country
    fields = '__all__'

  def validate_name(self, value):
    if Country.objects.filter(name__iexact=value).exists():
        raise serializers.ValidationError('Country already exists.') 
    return value.title()

  def validate_description(self, value):
    if not value:
        raise serializers.ValidationError('Description cannot be empty.')
    return value
              

class StateSerializer(serializers.ModelSerializer):
    class Meta:
        model = State
        fields = '__all__'

class CitySerializer(serializers.ModelSerializer):
    class Meta:
        model = City
        fields = '__all__'

class PlaceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Place
        fields = '__all__'

class FoodPlaceSerializer(serializers.ModelSerializer):
    class Meta:
        model = FoodPlace
        fields = '__all__'

class ThingSerializer(serializers.ModelSerializer):
    class Meta:
        model = Thing
        fields = '__all__'