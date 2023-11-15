package team.tjusw.elmboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import team.tjusw.elmboot.po.OrderDetailet;

@Mapper
public interface OrderDetailetMapper {
	public int saveOrderDetailetBatch(List<OrderDetailet> list);
	

	public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderOd);
}
