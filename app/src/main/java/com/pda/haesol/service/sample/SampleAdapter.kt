package com.pda.haesol.service.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pda.haesol.R // 레이아웃 리소스를 가져올 때 사용하는 R 클래스

class SampleAdapter(private val sampleList: List<Sample>) : RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {

    // 아이템 뷰를 생성하고 뷰홀더를 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        // 아이템 뷰 레이아웃을 가져와서 뷰를 생성
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_demo3_item, // 아이템 뷰의 레이아웃 파일
            parent,
            false
        )
        return SampleViewHolder(itemView) // 뷰홀더 반환
    }

    // 아이템 뷰와 데이터를 뷰홀더에 바인딩
    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val currentItem = sampleList[position]
        holder.bind(currentItem) // 뷰홀더에 데이터를 바인딩하는 메서드 호출
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return sampleList.size
    }

    // 아이템 뷰의 레이아웃 구성요소들을 초기화하는 뷰홀더 클래스
    inner class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dataTypeTextView: TextView = itemView.findViewById(R.id.dataTypeTextView) // 데이터 타입 텍스트뷰
        private val dataValueTextView: TextView = itemView.findViewById(R.id.dataValueTextView) // 데이터 값 텍스트뷰

        // 뷰홀더에 데이터를 바인딩하는 메서드
        fun bind(sample: Sample) {
            dataTypeTextView.text = sample.dataType // 데이터 타입 텍스트 설정
            dataValueTextView.text = sample.dataValue // 데이터 값 텍스트 설정
        }
    }
}