package lk.ijse.gdse71.mrphone.model;

import lk.ijse.gdse71.mrphone.dto.ItemDetailDto;
import lk.ijse.gdse71.mrphone.util.CrudUtil;

import java.sql.SQLException;

public class ItemDetailModel {
    public boolean saveItem(ItemDetailDto itemDetailDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into item_detail values (?,?)", itemDetailDto.getItem_id(), itemDetailDto.getInventory_id());
    }

    public boolean updateItem(ItemDetailDto itemDetailDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("update item_detail set inventory_id=? where item_id=?", itemDetailDto.getInventory_id(), itemDetailDto.getItem_id());
    }
}
