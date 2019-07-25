package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntryRepo = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = currentId++;
        TimeEntry newTimeEntry = new TimeEntry(
            id,
            timeEntry.getProjectId(),
            timeEntry.getUserId(),
            timeEntry.getDate(),
            timeEntry.getHours()
        );
        timeEntryRepo.put(id, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        TimeEntry timeEntry = timeEntryRepo.get(id);
        if (timeEntry != null) return timeEntry;
        else return null;
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntries = new ArrayList<>(timeEntryRepo.values());
        if (timeEntries != null) return timeEntries;
        else return null;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry findTimeEntry = find(id);
        if (findTimeEntry != null) {
            TimeEntry updatedTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
            );
            timeEntryRepo.replace(id, updatedTimeEntry);
            return updatedTimeEntry;
        } else return null;
    }

    @Override
    public void delete(Long id) {
        timeEntryRepo.remove(id);
//        TimeEntry timeEntry = timeEntryRepo.get(id);
//        if (timeEntry != null) timeEntryRepo.remove(id);
    }
}
