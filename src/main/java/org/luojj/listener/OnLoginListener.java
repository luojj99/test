package org.luojj.listener;

import org.luojj.entity.User;

public interface OnLoginListener {
	public void onSuccess(User user);
	public void onError(String message);
}
