package com.trpg.session;

import lombok.Data;

/**
 * シナリオの詳細を格納する。
 * 
 * @author platykun
 *
 */
@Data
public class SessionOutline {
	/** セッションID */
	private int id;

	/** シナリオID */
	private int scenarioId;

	/** */
	private int status;

	/** タイトル */
	private String title;
}
