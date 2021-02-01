package com.example.kidsdrawingapp

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawing_view.setSizeForBrush(20.toFloat())
        val black=findViewById(R.id.black_color)as Button;
        val yellow=findViewById(R.id.yellow_color)as Button;
        val red=findViewById(R.id.red_color)as Button;
        val green=findViewById(R.id.green_color)as Button;
        val pink=findViewById(R.id.pink_color)as Button;
        val blue=findViewById(R.id.blue_color)as Button;
        val purple=findViewById(R.id.purple_color)as Button;
        val eraser=findViewById(R.id.eraser) as ImageButton;

        ib_brush.setOnClickListener {
            showBrushSizeChooserDialog()
        }
        black.setOnClickListener {
            changeColor(Color.BLACK);
        }
        yellow.setOnClickListener {
          changeColor(Color.YELLOW);
        }
        red.setOnClickListener {
          changeColor(Color.RED);
        }
        green.setOnClickListener {
           changeColor(Color.GREEN);
        }
        pink.setOnClickListener {
       changeColor(Color.parseColor("#9805B1"));
        }
        blue.setOnClickListener {
           changeColor(Color.BLUE);
        }
        purple.setOnClickListener {
            changeColor(Color.parseColor("#E600FF"));
        }
        eraser.setOnClickListener{
            changeColor(Color.WHITE);
        }


    }
    private fun changeColor(color:Int){
        drawing_view.setColorForBrush(color)
    }

    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallBtn = brushDialog.ib_small_brush
        val mediumBtn = brushDialog.ib_meduim_brush
        val largeBtn = brushDialog.ib_large_brush

        smallBtn.setOnClickListener {
            drawing_view.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        mediumBtn.setOnClickListener {
            drawing_view.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        largeBtn.setOnClickListener {
            drawing_view.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }
}