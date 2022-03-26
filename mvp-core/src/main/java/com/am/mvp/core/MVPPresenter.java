/*
 * Copyright (C) 2015 AlexMofer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.am.mvp.core;

/**
 * Presenter
 * Created by Alex on 2017/3/13.
 */
@SuppressWarnings("rawtypes")
public abstract class MVPPresenter<V extends MVPView, M extends MVPModel> {

    private MVPViewHolder<V> mViewHolder;
    private M mModel;

    /**
     * 设置View持有者
     *
     * @param holder View持有者
     * @return Presenter
     */
    @SuppressWarnings("unchecked")
    public <P extends MVPPresenter> P setViewHolder(MVPViewHolder<? extends MVPView> holder) {
        mViewHolder = (MVPViewHolder<V>) holder;
        return (P) this;
    }

    /**
     * 获取View
     *
     * @return View
     */
    protected V getView() {
        return mViewHolder == null ? null : mViewHolder.getView();
    }

    /**
     * 获取Model
     *
     * @return Model
     */
    protected M getModel() {
        return mModel;
    }

    /**
     * 设置Model
     *
     * @param model Model
     */
    protected void setModel(M model) {
        mModel = model;
        //noinspection unchecked
        mModel.setPresenter(this);
    }

    /**
     * 判断是否已绑定View
     *
     * @return 已绑定View时返回true
     */
    public boolean isAttachedToView() {
        return getView() != null;
    }
}