package kts.restaurant_application.services.Integration;

import static kts.restaurant_application.constants.OrderConstants.DB_NEW_ORDER_ID;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_DATETIME;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_ID;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_ID2;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_NOTE;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_PRICE;
import static kts.restaurant_application.constants.OrderConstants.DB_WRONG_ORDER_ID;
import static kts.restaurant_application.constants.OrderConstants.FIND_ALL_NUMBER_OF_ORDERS;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_FLOOR;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_ID;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_IS_DELETED;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_X;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_Y;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_STATE;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_DATE_OF_BIRTH;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_FIRSTNAME;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_ID;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_IS_DELETED;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_LASTNAME;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_PASSWORD;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_SALARY;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_USERNAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import kts.restaurant_application.model.TableStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.services.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;


    @Test()
    public void AtestFindAll() {
        Iterable<Order> found = orderService.findAll();

        int count = 0;
        for (Order u : found) {
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ORDERS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void BtestFindOneThrowsResponseStatusException() {
        orderService.findOne(DB_WRONG_ORDER_ID);
    }

    @Test
    public void CtestFindOne() {
        Order found = orderService.findOne(DB_ORDER_ID);
        assertEquals(DB_ORDER_ID, found.getId());
    }

    @Test
    public void DtestSave() {
//        RestourantTables restorantTables = new RestourantTables(DB_RESTOURANT_TABLE_NUMBER, DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
//        restorantTables.setId(DB_RESTOURANT_TABLE_ID);
//
//        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
//        waiter.setId(DB_WAITER_ID);

        Order item = new Order(DB_ORDER_PRICE, DB_ORDER_DATETIME);
        item.setId(10L);

        RestourantTables table = new RestourantTables();
        table.setId(100L);
        table.setFloor(1);
        table.setPositionY(1.0);
        table.setPositionX(1.0);
        table.setState(TableStatus.free);
        table.setIsDeleted(false);
        item.setRestourantTable(table);

        Order created = orderService.save(item);

        assertEquals(DB_NEW_ORDER_ID, created.getId());
    }

    @Test
    public void EtestDelete1ShouldReturnTrue() {
        boolean flag = orderService.delete(DB_ORDER_ID2);
        assertTrue(flag);
    }

    @Test(expected = ResponseStatusException.class)
    public void FtestDelete1ShouldReturnReturnResponseStatusException() {
        boolean flag = orderService.delete(DB_WRONG_ORDER_ID);
        assertTrue(flag);
    }


    @Test
    public void GtestDelete2() {
        RestourantTables restorantTables = new RestourantTables(DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order item = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);
        item.setId(DB_ORDER_ID + 1);

        boolean flag = orderService.delete(item);
        assertTrue(flag);
    }
}
