package ExamPreparation.bakery.repositories;

import ExamPreparation.bakery.entities.tables.interfaces.Table;
import ExamPreparation.bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private final Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Table table) {
        models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        return models.stream().filter(e -> e.getTableNumber() == number).
                findFirst().orElse(null);
    }
}
