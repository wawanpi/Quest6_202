package com.example.pertemuan8.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan8.R
import com.example.pertemuan8.model.Mahasiswa
import com.example.pertemuan8.model.RencanaStudi

@Composable
fun TampilData(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackButtonClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.umy),
            contentDescription = "",
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(60.dp)
        )

        Spacer(modifier = Modifier.padding(start = 16.dp))
        Column(modifier = Modifier.weight(1f)){
            Text(
                text= mahasiswa.nama,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White
            )
            Text(
                text = mahasiswa.nim,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White
            )
        }
        Box{
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
    Box(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            )
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Data Diri Mahasiswa",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "Hasil Rencana Studi",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.padding(8.dp))
            HasilData(
                Judul  = "Nama",
                Isinya = mahasiswa.nama
            )
            Spacer(modifier = Modifier.padding(4.dp))
            HasilData(
                Judul  = "NIM",
                Isinya = mahasiswa.nim
            )
            Spacer(modifier = Modifier.padding(4.dp))
            HasilData(
                Judul  = "Email",
                Isinya = mahasiswa.email
            )
            Spacer(modifier = Modifier.padding(4.dp))
            HasilData(
                Judul  = "Mata Kuliah",
                Isinya = rencanaStudi.namaMk
            )
            Spacer(modifier = Modifier.padding(4.dp))
            HasilData(
                Judul  = "Kelas",
                Isinya = rencanaStudi.kelas
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row  (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {onBackButtonClicked()}
                ) {
                    Text("Kembali ke Halaman Utama")
                }
            }
        }
    }
}
@Composable
fun HasilData(
    Judul: String,
    Isinya:String
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(Judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(Isinya, modifier = Modifier.weight(2f))
    }
}