package lk.ijse.gdse71.mrphone.model;

import lk.ijse.gdse71.mrphone.dto.OrderDetailDto;
import lk.ijse.gdse71.mrphone.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel {
    private final ItemModel itemModel = new ItemModel();

    public boolean saveOrderDetailList(ArrayList<OrderDetailDto> orderDetailDtos) throws SQLException, ClassNotFoundException {
        for (OrderDetailDto orderDetailDto : orderDetailDtos) {
            boolean isOderDetailSaved = saveOrderDetail(orderDetailDto);
            if (!isOderDetailSaved) {
                return false;
            }

            boolean isItemUpdate = itemModel.reduceQty(orderDetailDto);
            if (!isItemUpdate) {
                return false;
            }
        }
        return true;
    }

    private boolean saveOrderDetail(OrderDetailDto orderDetailDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "insert into orderdetail values (?,?,?,?)",
                orderDetailDto.getOrderId(),
                orderDetailDto.getItemId(),
                orderDetailDto.getQty(),
                orderDetailDto.getPrice()
        );
    }
}
