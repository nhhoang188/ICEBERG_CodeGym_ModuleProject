package com.icebergsocialnetwork.services.like;

import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.services.IGenericService;

public interface ILove extends IGenericService<Love> {
    Love findByUser_Id (Long id);


}
