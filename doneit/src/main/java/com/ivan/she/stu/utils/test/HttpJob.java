/**
 * 
 */
package com.ivan.she.stu.utils.test;

/**
 * @author shezhigao
 *
 */
public class HttpJob implements Runnable {
	
	private String name;
	
	public HttpJob() {
		// TODO Auto-generated constructor stub
	}
	
	public HttpJob(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String res = null;
		String jsonStr = "{\"data\":{\"TheCase\":\""+name+"\",\"account\":\"2000\",\"period\":\"28\",\"product_id\":\"S9999\",\"tracker_u\":\"uuuuu22222\"},\"ipAddress\":\"116.226.234.239\",\"tokenId\":\"socian-1490865835317-a66481ff\",\"user\":{\"addlat\":0,\"addlng\":0,\"addtime\":1488192467000,\"card_face_imgurl\":\"http://ssdai.b0.upaiyun.comhttp://ssdai.b0.upaiyun.com/2017/03/29/29e722908af9d1c7f2d3ca0eeacaa7dc.jpg\",\"card_front_imgurl\":\"http://ssdai.b0.upaiyun.comhttp://ssdai.b0.upaiyun.com/2017/03/29/ad6a1a8e6ec65718dc500d62605c75c4.jpg\",\"card_id\":\"310110198403043716\",\"card_reverse_imgurl\":\"http://ssdai.b0.upaiyun.comhttp://ssdai.b0.upaiyun.com/2017/03/29/ff430dbf544cc2e27b9a6cad45dd9b6e.jpg\",\"isIspVerifyed\":1,\"loan_apply_flow_status\":60,\"login_tracker\":\"uuuuu22222\",\"password\":\"eabd8ce9404507aa8c22714d3f5eada9\",\"phone\":\"13816709866\",\"realname\":\"梁迪\",\"recomm_telephone\":\"0\",\"status\":0,\"updatetime\":1490865855000,\"user_id\":1119}}";
		long start = System.currentTimeMillis();
		System.out.println(name+"\t start");
		res = HttpUtils.executePostJson("http://127.0.0.1:8080/ss-app-api/"+"submitApply.html", jsonStr);
		long end = System.currentTimeMillis();
		System.out.println(name+"\ttime:\t"+(end-start)+"\tresult:\t"+res);
	}

}
}
