package com.pda.haesol.ui.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pda.haesol.databinding.FragmentSampleBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SampleFragment : Fragment() {

    // ViewBinding을 위한 변수
    private var _binding: FragmentSampleBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    // 선택한 날짜를 저장하는 변수
    private lateinit var selectedDate: Calendar

    // ViewModel 객체 생성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSampleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {
            binding.textView2.text = "Hello, ViewModel!"
        }

        // CalendarView 위젯에 날짜 선택 이벤트 리스너 설정
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // 선택한 날짜를 Calendar 객체에 저장
            selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)

            // 선택한 날짜를 TextView에 표시
            updateDateInView()
        }

        return root
    }

    // 선택한 날짜를 TextView에 업데이트하는 함수
    private fun updateDateInView() {
        // 날짜 형식을 지정
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        // 선택한 날짜를 형식에 맞게 변환하여 문자열로 가져옴
        val selectedDateString = dateFormat.format(selectedDate.time)
        // TextView에 선택한 날짜 문자열을 표시
        binding.textView2.text = selectedDateString
    }

    // Fragment가 더 이상 사용되지 않을 때 호출되는 함수
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}