package calculate;

public class Calculate
{
double a,b; char c;
double [] stack1 = new double[10];
char [] stack2 = new char[10];
int top1=-1,top2=-1;
String s;


public Calculate(String s)
{
this.s = s;
}

void push(double a)
{
stack1[++top1]=a;
}
void push(char a)
{
stack2[++top2]=a;
}

double pop1()
{
return stack1[top1--];
}
char pop2()
{
return stack2[top2--];
}

int precedence(char a)
{
if(a=='^')
return 3;
else if(a=='*'||a=='/')
return 2;
else if(a=='+' || a=='-')
return 1;
else 
return 0; 
}

public String Evaluate()
{

int b1=0;
for(int i=0 ; i<this.s.length();i++)
{
c = this.s.charAt(i);
if((int)c >=48 && (int)c <=57)
{
if(b1==0)
{
    a = c-'0';b1=1;
}
else
{
a=a*10+(c-'0');
}
}
else if(c=='(')
{
b1=0;
push(c);
}
else if(c==')')
{
if(b1 !=0){
push(a);b1=0;
}
while(stack2[top2] !='(')
{
a = pop1();
b=pop1();
switch(pop2())
{
case '+':
push(a+b);break;

case '-':
push(b-a);break;

case '*':
push(a*b);break;

case '/':
push(b/a);break;

case '^':
push(Math.pow(b,a));break;
}

}
pop2();
}
else if(c=='!')
{
if(b1!=0){
push(a);
b1=0;
}
push(factorial((int)pop1()));
}

else if(c=='+' || c=='-'|| c=='*' || c=='/' || c=='^')
{
if(b1!=0){
push(a);
b1=0;
}
a=0;b=0;
if(top2==-1)
{
push(c);
}
else if(precedence(c) > precedence(stack2[top2]) )
{
push(c);
}
else
{
while(top2>-1 && (precedence(c) <= precedence(stack2[top2])))
{
a = pop1();
b=pop1();
switch(pop2())
{
case '+':
push(a+b);break;

case '-':
push(b-a);break;

case '*':
push(a*b);break;

case '/':
push(b/a);break;
        
case '^':
push(Math.pow(b,a));break;
}
}
push(c);
}
}
}
if(top2>-1)
{
if(b1!=0){
b1=0;
push(a);
}
while(top2>-1)
{
a = pop1();
b=pop1();

switch(pop2())
{
case '+':
push(a+b);break;

case '-':
push(b-a);break;

case '*':
push(a*b);break;

case '/':
if(a==0)
return "Syntax Error";
push(b/a);
break;

case '^':
push(Math.pow(b,a));break;
}
}
}
if(top1>-1)
return String.valueOf(stack1[top1]);
else
return String.valueOf(this.s);
}

int factorial(int n)
{
if(n==0|| n==1)
return 1;
else if(n==2)
return 2;
else if(n==3)
return 6;
else
{
return n*factorial(n-1);
}
}
}


