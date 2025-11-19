package com.example.quizzlers;

public class DefinitionCard extends Card {
    public String name;
    public String definition;

    public final String DEFAULT_STRING = "Dog";
    public final String DEFAULT_DEFINITION= "Mans best friend.";

    public void setName(String name) {
        this.name = name;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setAll(String name, String definition) {
        this.name = name;
        this.definition = definition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDefinition() {
        return definition;
    }

    public DefinitionCard() {
        this.name = DEFAULT_STRING;
        this.definition = DEFAULT_DEFINITION;
    }

    public DefinitionCard(String name, String definition) {
        this.name = name;
        this.definition = definition;
    }

    public DefinitionCard(DefinitionCard original) {
        this.name = original.name;
        this.definition = original.definition;
    }

    @Override
    public String toString() {
        return "Quiz Card: " + "Name: " + name + "[--|--] Definition: " + definition;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) return false;

        DefinitionCard other = (DefinitionCard) obj;
        return name == other.name && definition.equals(other.definition);
    }
}
