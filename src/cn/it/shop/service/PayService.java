package cn.it.shop.service;

import java.util.Map;

import cn.it.shop.model.BackData;
import cn.it.shop.model.SendData;

public interface PayService {

	// �Ѽ��ܺ����Ϣ�洢��requestMap��
	/* (non-Javadoc)
	 * @see cn.itcast.shop.service.impl.PayService#saveDataToRequest(java.util.Map, cn.itcast.shop.pojo.SendData)
	 */
	//@Override
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);
	
	public abstract boolean checkBackData(BackData backData);

}