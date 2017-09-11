package com.huangyongsheng.hearthstone.pojo.dto;

import net.sf.json.JSONObject;

public class ResultModel {

	private JSONObject mata;
	private Object data;

	public static ResultModel error(ResultStatus resultStatus) {
		ResultModel resultModel = new ResultModel();
		JSONObject mata = new JSONObject();
		mata.put("code", resultStatus.getCode());
		mata.put("error", resultStatus.getError());
		mata.put("info", resultStatus.getInfo());
		resultModel.setMata(mata);
		return resultModel;
	}

	public static ResultModel error(ResultStatus resultStatus, Object data) {
		ResultModel resultModel = error(resultStatus);
		resultModel.setData(JSONObject.fromObject(data));
		return resultModel;
	}

	public static ResultModel ok(ResultStatus resultStatus) {
		ResultModel resultModel = new ResultModel();
		JSONObject mata = new JSONObject();
		mata.put("code", resultStatus.getCode());
		String info = resultStatus.getInfo();
		if (info != null) {
			mata.put("info", resultStatus.getInfo());
		}
		resultModel.setMata(mata);

		resultModel.setData(new JSONObject(true));
		return resultModel;
	}

	public static ResultModel ok(ResultStatus resultStatus, Object data) {
		ResultModel resultModel = ok(resultStatus);
		resultModel.setData(data);
		return resultModel;
	}

	public JSONObject getMata() {
		return mata;
	}

	public void setMata(JSONObject mata) {
		this.mata = mata;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
