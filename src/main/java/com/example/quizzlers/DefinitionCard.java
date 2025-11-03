package com.example.quizzlers;

public class DefinitionCard {
    //Instance Variables
    public String name;
    public String definition;
    public String category;

    public final String DEFAULT_STRING = "Dog";
    public final String DEFAULT_DEFINITION= "Mans best friend.";
    public final String DEFAULT_CATEGORY = "Animals";

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setCatigory(String category) {
        this.category = category;
    }

    public void setAll(String name, String definition, String category) {
        this.name = name;
        this.definition = definition;
        this.category = category;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public String getCategory() {
        return category;
    }

    //Constructors

    //Default Constructor
    public DefinitionCard() {
        this.name = DEFAULT_STRING;
        this.definition = DEFAULT_DEFINITION;
        this.category = DEFAULT_CATEGORY;
    }

    //Paramaterized Constructor
    public DefinitionCard(String name, String definition, String category) {
        this.name = name;
        this.definition = definition;
        this.category = category;
    }

    //Copy Constructor
    public DefinitionCard(DefinitionCard original) {
        this.name = original.name;
        this.definition = original.definition;
        this.category = original.category;
    }

    //Other methods
    @Override
    public String toString() {
        return "Quiz Card: " + "Name: " + name + "[--|--] Definition: " + definition + "[--|--] Category: " + category;
    }

    //Equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) return false;

        DefinitionCard other = (DefinitionCard) obj;
        return name == other.name && definition.equals(other.definition) && category.equals(other.category);
    }
}