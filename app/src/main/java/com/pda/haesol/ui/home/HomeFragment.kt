package com.pda.haesol.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pda.haesol.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // HomeViewModel 인스턴스 생성
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        // View Binding을 사용하여 프래그먼트의 레이아웃 초기화
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // TextView를 찾아서 ViewModel의 데이터를 설정
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // View Binding 관련 리소스 해제
        _binding = null
    }
}