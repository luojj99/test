package org.luojj.listener;

import org.luojj.model.User;

public interface OnLoginListener {
	public void onSuccess(User user);
	public void onError(String message);
}
