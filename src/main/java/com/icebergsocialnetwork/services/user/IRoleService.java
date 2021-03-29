package com.icebergsocialnetwork.services.user;

import com.icebergsocialnetwork.model.user.Role;
import com.icebergsocialnetwork.services.IGenericService;

public interface IRoleService extends IGenericService<Role> {
    Role findByName(String name);
}
