package com.quyunshuo.horizontalselector

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @Author: QuYunShuo
 * @Time:   2020/6/6
 * @Class:  LotteryAdapter
 * @Remark:
 */
class LotteryAdapter(data: MutableList<LotteryBean>) :
    BaseQuickAdapter<LotteryBean, BaseViewHolder>(R.layout.lottery_item_layout, data) {

    override fun convert(holder: BaseViewHolder, item: LotteryBean) {
        holder.setText(R.id.numberTv, if (item.isDefault) "?" else item.number.toString())
        holder.setBackgroundResource(R.id.itemLayout, item.backgroundId)
    }
}