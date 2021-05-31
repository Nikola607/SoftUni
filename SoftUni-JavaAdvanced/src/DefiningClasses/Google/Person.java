package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    private Company company;
    private List<Pokemon> pokemon;
    private Parents parents;
    private List<Children> children;
    private Car car;

    public Person(String name, Company company, Parents parents, Car car) {
        this.name = name;
        this.company = company;
        this.pokemon = new ArrayList<>();
        this.parents = parents;
        this.children = new ArrayList<>();
        this.car = car;
    }

    public Person(String name) {
        this(name, null, null, null);
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public Parents getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name);
        sb.append(System.lineSeparator());
        sb.append("Company:").
                append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.toString()).append(System.lineSeparator());
        }
        sb.append("Car:").
                append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.toString()).append(System.lineSeparator());
        }
        sb.append("Pokemon:").
                append(System.lineSeparator());
        if (this.pokemon != null) {
            this.pokemon.stream().forEach(e -> sb.append(e).append(System.lineSeparator()));
        }
        sb.append("Parents:").
                append(System.lineSeparator());
        if (this.parents != null) {
            sb.append(this.parents.toString()).append(System.lineSeparator());
        }
        sb.append("Children:").
                append(System.lineSeparator());
        if (this.children != null) {
            this.children.stream().forEach(e -> sb.append(e).append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }
}
