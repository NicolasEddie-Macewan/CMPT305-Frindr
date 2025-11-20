package com.example.frindr.ui;

import com.example.frindr.backend.fruit.Complete_tree;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class MenuBuilder {
    private Complete_tree trees;

    public MenuBuilder(Complete_tree trees) {
        this.trees = trees;
    }

    public TitledPane createFruitFilters() {
        List<String> fruit = List.of(
                "Crabapple",
                "Acorn",
                "Chokecherry",
                "Cherry",
                "Hawthorn",
                "Russian Olive",
                "Plum",
                "Pear",
                "Apple",
                "Caragana Flower/Pod",
                "Juniper",
                "Hackberry",
                "Coffeetree Pod",
                "Butternut",
                "Saskatoon",
                "Walnut");

        List<CheckBox> checkBoxes = fruit.stream()
                .map(CheckBox::new)
                .toList();
        VBox content = new VBox();
        content.getChildren().addAll(checkBoxes);

        TitledPane fruitFilters = new TitledPane("Fruit Filters", content);
        fruitFilters.setExpanded(false);
        return fruitFilters;
    }

    public TitledPane createNeighbourhoodFilters() {
        List<String> neighbourhoods = List.of("");

        List<CheckBox> checkBoxes = neighbourhoods.stream()
                .map(CheckBox::new)
                .toList();
        VBox content = new VBox();
        content.getChildren().addAll(checkBoxes);

        TitledPane neighbourhoodFilters = new TitledPane("Neighbourhoods", content);
        neighbourhoodFilters.setExpanded(false);
        return neighbourhoodFilters;
    }
}
