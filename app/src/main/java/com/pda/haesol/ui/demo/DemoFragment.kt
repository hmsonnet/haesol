package com.pda.haesol.ui.demo

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pda.haesol.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    // ViewBinding을 위한 변수
    private var _binding: FragmentDemoBinding? = null

    private val binding get() = _binding!!

    // ViewModel 객체 생성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // DemoViewModel 인스턴스 생성
        val demoViewModel =
            ViewModelProvider(this).get(DemoViewModel::class.java)

        // View Binding을 사용하여 프래그먼트의 레이아웃 초기화
        _binding = FragmentDemoBinding.inflate(inflater, container, false)

        // TextView를 찾아서 ViewModel의 데이터를 설정
        val root: View = binding.root

        // TextView를 찾아서 ViewModel의 데이터를 설정
        val textView : TextView = binding.textView3

        // LiveData를 사용하여 데모 데이터를 표시
        demoViewModel.demo.observe(viewLifecycleOwner) {
            textView.text = it // LiveData 값이 변화하면 textView 업데이트
            // 팝업 호출
            popup()
        }

        // 버튼 클릭 이벤트 리스너 설정
        binding.button2.setOnClickListener {
            // 랜덤 문자열 생성
            val randomString = (1..10).map { ('a'..'z').random() }.joinToString("")

            // DemoViewModel의 값을 업데이트
            demoViewModel.updateDemoValue(randomString)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.button4.setOnClickListener {
            viewModel.setData(binding.textView3.text.toString())
        }
    }

    private fun popup() {
        // 다이얼로그 생성
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("알림")
        alertDialogBuilder.setMessage("이것은 AlertDialog의 예시입니다.")
        alertDialogBuilder.setPositiveButton("확인") { dialog, _ ->
            // 확인 버튼 클릭 시 동작
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 표시
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}