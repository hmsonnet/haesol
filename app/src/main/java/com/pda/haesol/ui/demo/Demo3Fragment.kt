package com.pda.haesol.ui.demo

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pda.haesol.databinding.FragmentDemo3Binding
import com.pda.haesol.service.sample.RetrofitInstance
import com.pda.haesol.service.sample.Sample
import com.pda.haesol.service.sample.SampleAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Demo3Fragment : Fragment() {

    private val sampleService = RetrofitInstance.sampleService

    private var _binding: FragmentDemo3Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val demo3ViewModel = ViewModelProvider(this).get(Demo3ViewModel::class.java)

        _binding = FragmentDemo3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView = binding.textView4
        demo3ViewModel.textViewValue.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.button5.setOnClickListener {
            fetchData()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchData() {
        sampleService.getSampleList().enqueue(object : Callback<List<Sample>> {
            override fun onResponse(call: Call<List<Sample>>, response: Response<List<Sample>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    // 데이터 처리
                    popup("데이터 처리")

                    // 리사이클러뷰에 데이터 바인딩
                    val recyclerView: RecyclerView = binding.recyclerView
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                    recyclerView.adapter = SampleAdapter(data!!)


                } else {
                    // 오류 처리
                    popup("오류 발생")
                }
            }

            override fun onFailure(call: Call<List<Sample>>, t: Throwable) {
                // 네트워크 오류 처리
                popup("네트워크 오류 : " + t.message)
            }
        })
    }

    private fun popup(msg: String) {
        // 다이얼로그 생성
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("알림")
        alertDialogBuilder.setMessage(msg)
        alertDialogBuilder.setPositiveButton("확인") { dialog, _ ->
            // 확인 버튼 클릭 시 동작
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 표시
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}