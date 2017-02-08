import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 */
class XSpeedItImplementationTest {

    @Test
    void should_pack_all_items_with_size_between_1_and_9() {

        List<Item> items = Arrays.asList(
                new Item(9),
                new Item(5),
                new Item(3),
                new Item(5),
                new Item(0),
                new Item(64),
                new Item(2)
        );

        XSpeedItImplementation xspeedit = new XSpeedItImplementation();
        List<Packaging> packages = xspeedit.pack(items);

        List<Item> outputItems = packages.stream().flatMap(p -> p.getItems().stream()).collect(Collectors.toList());

        assertTrue(outputItems.stream().noneMatch(
            item -> item.getSize() < 1 || item.getSize() > 9
        ));

    }

    @Test
    void should_not_exceed_package_size_of_10() {
        List<Item> items = Arrays.asList(
                new Item(9),
                new Item(8),
                new Item(7),
                new Item(6),
                new Item(5),
                new Item(4),
                new Item(3)
        );

        XSpeedItImplementation xspeedit = new XSpeedItImplementation();
        List<Packaging> packages = xspeedit.pack(items);

        assertTrue(packages.stream().noneMatch(p -> p.size() > 10));
    }

    @Test
    void should_not_create_empty_packages() {
        List<Item> items = Arrays.asList(
                new Item(1),
                new Item(2),
                new Item(3)
        );

        XSpeedItImplementation xspeedit = new XSpeedItImplementation();
        List<Packaging> packages = xspeedit.pack(items);

        assertTrue(packages.stream().noneMatch(p -> p.size() == 0));
    }

    @Test
    void should_return_empty_package_list_when_no_eligible_item() {
        List<Item> items = Arrays.asList(
                new Item(12),
                new Item(-45),
                new Item(Integer.MAX_VALUE)
        );

        XSpeedItImplementation xspeedit = new XSpeedItImplementation();
        List<Packaging> packages = xspeedit.pack(items);

        assertTrue(packages.stream().noneMatch(p -> p.size() == 0));
    }

    @Test
    void should_return_empty_package_list_when_no_item() {
        List<Item> items = new ArrayList<>();

        XSpeedItImplementation xspeedit = new XSpeedItImplementation();
        List<Packaging> packages = xspeedit.pack(items);

        assertTrue(packages.stream().noneMatch(p -> p.size() == 0));
    }
    
    
}