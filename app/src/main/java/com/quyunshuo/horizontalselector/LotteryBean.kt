package com.quyunshuo.horizontalselector

import androidx.annotation.IdRes

/**
 * @Author: QuYunShuo
 * @Time:   2020/6/6
 * @Class:  LotteryBean
 * @Remark:
 */
data class LotteryBean(
    val number: Int,
    @IdRes val backgroundId: Int,
    val isDefault: Boolean = false
)