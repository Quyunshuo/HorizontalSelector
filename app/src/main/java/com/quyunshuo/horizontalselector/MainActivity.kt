package com.quyunshuo.horizontalselector

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.quyunshuo.horizontalselector.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mCenterLayoutManager by lazy { CenterLayoutManager(this) }

    // 被抽到的倍数
    private val mLotteryNumber = 2

    // 翻倍数据的背景
    private val mItemBackgrounds = intArrayOf(
        R.mipmap.item_bg_1,
        R.mipmap.item_bg_2,
        R.mipmap.item_bg_3,
        R.mipmap.item_bg_4,
        R.mipmap.item_bg_5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initView()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        val lotteryAdapter = LotteryAdapter(getLotteryData())
        mBinding.lotteryRv.layoutManager = mCenterLayoutManager
        mBinding.lotteryRv.adapter = lotteryAdapter
        mBinding.lotteryRv.isClickable = false
        mBinding.lotteryRv.setOnTouchListener { _, _ -> true }
        mBinding.lotteryRv.post { designatedLocation(3) }
        mBinding.startTv.setOnClickListener { designatedLocation(26) }
        mBinding.resetTv.setOnClickListener { designatedLocation(3) }
    }

    /**
     * 滑动到指定位置
     */
    private fun designatedLocation(index: Int) {
        mCenterLayoutManager.smoothScrollToPosition(
            mBinding.lotteryRv,
            RecyclerView.State(),
            index
        )
    }

    /**
     * 获取滚轮的item数据
     */
    private fun getLotteryData(): MutableList<LotteryBean> {
        val mutableList = mutableListOf<LotteryBean>()
        for (index in 1..30) {
            when (index) {
                4 -> mutableList.add(LotteryBean(0, mItemBackgrounds[index % 5], true))
                27 -> mutableList.add(LotteryBean(mLotteryNumber, mItemBackgrounds[index % 5]))
                else -> mutableList.add(LotteryBean((3..9).random(), mItemBackgrounds[index % 5]))
            }
        }
        return mutableList
    }
}