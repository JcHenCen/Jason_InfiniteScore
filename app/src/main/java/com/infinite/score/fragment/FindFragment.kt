package com.infinite.score.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.baselibrary.base.BaseFragment
import com.example.baselibrary.base.*
import com.infinite.score.R
import com.infinite.score.ui.RecommendedActivity

/**
 * 发现
 */
class FindFragment : Fragment() {

    private lateinit var for_you_more: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_find, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for_you_more = view.findViewById(R.id.for_you_more)

        for_you_more.id = R.id.tv_recommend_more
        for_you_more.setOnClickListener {
            var intent = Intent()
            intent.setClass(view.context, RecommendedActivity::class.java)
            startActivity(intent)
        }

    }








}