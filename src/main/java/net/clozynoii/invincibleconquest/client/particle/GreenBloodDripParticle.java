
package net.clozynoii.invincibleconquest.client.particle;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;

import net.clozynoii.invincibleconquest.procedures.BloodDripGreenOnGroundProcedure;

@OnlyIn(Dist.CLIENT)
public class GreenBloodDripParticle extends TextureSheetParticle {
	public static GreenBloodDripParticleProvider provider(SpriteSet spriteSet) {
		return new GreenBloodDripParticleProvider(spriteSet);
	}

	public static class GreenBloodDripParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public GreenBloodDripParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new GreenBloodDripParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected GreenBloodDripParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.quadSize *= 1.3f;
		this.lifetime = (int) Math.max(1, 10 + (this.random.nextInt(60) - 30));
		this.gravity = 1f;
		this.hasPhysics = true;
		this.xd = vx * 1;
		this.yd = vy * 1;
		this.zd = vz * 1;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		Level world = this.level;
		if (BloodDripGreenOnGroundProcedure.execute(world, x, y, z, onGround))
			this.remove();
	}
}
