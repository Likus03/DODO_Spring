CREATE OR REPLACE FUNCTION calculate_and_insert() RETURNS TRIGGER AS
'
BEGIN
UPDATE orders
SET total_cost = (
    SELECT COALESCE(SUM(menus.cost), 0)
    FROM menus
             INNER JOIN order_describes ON menus.id = order_describes.menu_id
    WHERE order_describes.order_id = NEW.order_id
)
WHERE orders.id = NEW.order_id;
RETURN NEW;
END;
' LANGUAGE plpgsql;