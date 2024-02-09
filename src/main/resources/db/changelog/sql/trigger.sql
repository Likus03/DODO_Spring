CREATE TRIGGER calculate_total_cost
    AFTER INSERT ON order_describes
    FOR EACH ROW
    EXECUTE FUNCTION calculate_and_insert();